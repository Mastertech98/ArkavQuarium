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
    Aquarium aquarium = Aquarium(640, 480);
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
            case SDLK_g:
                aquarium.add(Guppy(aquarium));
                break;
            case SDLK_p:
                aquarium.add(Piranha(aquarium));
                break;
            case SDLK_f:
                aquarium.add(Food(aquarium, 400));
                break;
            case SDLK_ESCAPE:
                running = false;
                break;
            case SDLK_SPACE:
                paused = !paused;
                break;
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
        draw_text("G: Guppy, P: Piranha, F: Food, Esc: Quit, Space: Pause", 18, 10, 10, 0, 0, 0);
        draw_text("Money: " + std::to_string(aquarium.getMoney()), 18, 10, 60, 0, 0, 0);
        draw_text("Egg: " + std::to_string(aquarium.getEgg()), 18, 10, 90, 0, 0, 0);
        draw_text(fps_text, 18, 10, 30, 0, 0, 0);
        for (ElementList<Guppy>* o = aquarium.getGuppies().getFirst(); o != 0; o = o->next) {
            Vector2 position = o->data.getPosition();
            if (o->data.getIsMovingRight()) {
                draw_image("Guppy_Normal_R.png", (int)position.x, (int)position.y);
            } else {
                draw_image("Guppy_Normal_L.png", (int)position.x, (int)position.y);
            }
        }
        for (ElementList<Piranha>* o = aquarium.getPiranhas().getFirst(); o != 0; o = o->next) {
            Vector2 position = o->data.getPosition();
            if (o->data.getIsMovingRight()) {
                draw_image("Piranha_Normal_R.png", (int)position.x, (int)position.y);
            } else {
                draw_image("Piranha_Normal_L.png", (int)position.x, (int)position.y);
            }
        }
        for (ElementList<Snail>* o = aquarium.getSnails().getFirst(); o != 0; o = o->next) {
            Vector2 position = o->data.getPosition();
            if (o->data.getIsMovingRight()) {
                draw_image("Snail_R.png", (int)position.x, (int)position.y);
            } else {
                draw_image("Snail_L.png", (int)position.x, (int)position.y);
            }
        }
        for (ElementList<Food>* o = aquarium.getFoods().getFirst(); o != 0; o = o->next) {
            Vector2 position = o->data.getPosition();
            draw_image("Food.png", (int)position.x, (int)position.y);
        }
        for (ElementList<Coin>* o = aquarium.getCoins().getFirst(); o != 0; o = o->next) {
            Vector2 position = o->data.getPosition();
            draw_image("Coin.png", (int)position.x, (int)position.y);
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