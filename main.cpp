#include "oop.hpp"
#include <iostream>
#include <math.h>
#include <sstream>

#include "Aquarium.hpp"

const double speed = 1;
const double tps = 20;

int main( int argc, char* args[] )
{
    init();

    // FPS Counter
    int frames_passed = 0;
    double fpc_start = time_since_start();

    // Text String
    std::string fps_text = "FPS: 0";
    std::string money_text = "Money: 0";
    std::string egg_text = "Egg: 0";

    // Initialize Game
    Aquarium aquarium = Aquarium(get_screen_width(), get_screen_height() - 192);
    bool running = true;
    bool paused = false;
    bool win;

    double prevtime = time_since_start();

    while (running) {
        // Game Tick
        double now = time_since_start();
        if (now - prevtime > speed / tps && !paused) {
            aquarium.tick();
            prevtime = now;
        }

        // Input Handler
        handle_input();
        if (quit_pressed()) {
            running = false;
        }

        for (auto key : get_pressed_keys()) {
            switch (key) {
            default: break;
            }
        }

        for (auto key : get_tapped_keys()) {
            switch (key) {
            case SDLK_ESCAPE:
                running = false;
                break;
            case SDLK_SPACE:
                paused = !paused;
                break;
            }
        }

        if (get_mouse_button_tapped()) {
            int x, y;
            SDL_GetMouseState(&x, &y);

            int money = aquarium.getMoney();
            if (y > 128) {
                y -= 128;
                Vector2 mousePosition = Vector2(x, y);
                bool coinClick = false;
                for (ElementList<Coin>* o = aquarium.getCoins().getFirst(); o != 0 && !coinClick; o = o->next) {
                    if (mousePosition.distance(o->data.getPosition()) <= 16) {
                        o->data.take();
                        coinClick = true;
                    }
                }
                if (money > Food::price && !coinClick) {
                    aquarium.add(Food(aquarium, x));
                    aquarium.setMoney(money - Food::price);
                }
            } else {
                if (x < 128) {
                    if (money > Guppy::price) {
                        aquarium.add(Guppy(aquarium));
                        aquarium.setMoney(money - Guppy::price);
                    }
                } else if (x < 256) {
                    if (money > Piranha::price) {
                        aquarium.add(Piranha(aquarium));
                        aquarium.setMoney(money - Piranha::price);
                    }
                } else if (x < 384) {
                    if (money > aquarium.getEggPrice()) {
                        aquarium.setEgg(aquarium.getEgg() + 1);
                        aquarium.setMoney(money - aquarium.getEggPrice());
                    }
                }
            }
        }

        // Update FPS every second
        frames_passed++;
        if (now - fpc_start > 1) {
            std::ostringstream strs;
            strs << "FPS: " ;
            strs << frames_passed/(now - fpc_start);
            fps_text = strs.str();;
            fpc_start = now;
            frames_passed = 0;
        }

        // Draw
        clear_screen();

        draw_background("background");

        draw_image("buyguppy", 64, 64);
        draw_image("buypiranha", 192, 64);
        draw_image("buyegg", 320, 64);

        draw_text("Esc: Quit, Space: Pause", 18, get_screen_width() - 256, 8, 0, 0, 0);
        draw_text("Money: " + std::to_string(aquarium.getMoney()), 18, get_screen_width() - 256, 40, 0, 0, 0);
        draw_text("Egg: " + std::to_string(aquarium.getEgg()), 18, get_screen_width() - 256, 72, 0, 0, 0);
        draw_text(fps_text, 18, 0, get_screen_height() - 24, 0, 0, 0);

        for (ElementList<Guppy>* o = aquarium.getGuppies().getFirst(); o != 0; o = o->next) {
            Guppy guppy = o->data;
            Vector2 position = guppy.getPosition();
            draw_image(
                "guppy" + std::to_string(guppy.getGrowthStage()) + std::to_string(guppy.getIsMovingRight()), (int)position.x, (int)position.y + 128);
        }
        for (ElementList<Piranha>* o = aquarium.getPiranhas().getFirst(); o != 0; o = o->next) {
            Piranha piranha = o->data;
            Vector2 position = piranha.getPosition();
            draw_image("piranha" + std::to_string(piranha.getIsMovingRight()), (int)position.x, (int)position.y + 128);
        }
        for (ElementList<Snail>* o = aquarium.getSnails().getFirst(); o != 0; o = o->next) {
            Snail snail = o->data;
            Vector2 position = snail.getPosition();
            draw_image("snail" + std::to_string(snail.getIsMovingRight()), (int)position.x, (int)position.y + 128);
        }
        for (ElementList<Food>* o = aquarium.getFoods().getFirst(); o != 0; o = o->next) {
            Vector2 position = o->data.getPosition();
            draw_image("food", (int)position.x, (int)position.y + 128);
        }
        for (ElementList<Coin>* o = aquarium.getCoins().getFirst(); o != 0; o = o->next) {
            Vector2 position = o->data.getPosition();
            draw_image("coin", (int)position.x, (int)position.y + 128);
        }
        update_screen();

        // Win/Lose Condition
        if (aquarium.getEgg() >= 3) {
            win = true;
            running = false;
        } else {
            if (aquarium.getGuppies().isEmpty() && aquarium.getPiranhas().isEmpty()) {
                int money = aquarium.getMoney();
                if (money < Guppy::price && money < Piranha::price) {
                    win = false;
                    running = false;
                }
            }
        }
    }

    close();

    return 0;
}