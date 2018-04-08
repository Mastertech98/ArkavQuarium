#include "oop.hpp"
#include <iostream>
#include <math.h>
#include <sstream>

#include "Aquarium.hpp"

const double speed = 50; // pixels per second

int main( int argc, char* args[] )
{
    init();

    // Menghitung FPS
    int frames_passed = 0;
    double fpc_start = time_since_start();
    std::string fps_text = "FPS: 0";

    // Inisialisasi Aquarium
    Aquarium aquarium = Aquarium(640, 480);
    aquarium.add(Snail(aquarium));

    bool running = true;

    double prevtime = time_since_start();

    bool paused = false;

    while (running) {
        double now = time_since_start();
        if (now - prevtime >= 0.05 && !paused) {
            aquarium.setGameTime(aquarium.getGameTime() + 1);
            prevtime = now;
            for (ElementList<Guppy>* o = aquarium.getGuppies().getFirst(); o != 0; o = o->next) {
                o->data.tick();
            }
            for (ElementList<Piranha>* o = aquarium.getPiranhas().getFirst(); o != 0; o = o->next) {
                o->data.tick();
            }
            for (ElementList<Snail>* o = aquarium.getSnails().getFirst(); o != 0; o = o->next) {
                o->data.tick();
            }
            for (ElementList<Food>* o = aquarium.getFoods().getFirst(); o != 0; o = o->next) {
                o->data.tick();
            }
            for (ElementList<Coin>* o = aquarium.getCoins().getFirst(); o != 0; o = o->next) {
                o->data.tick();
            }
        }

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

        // Update FPS setiap detik
        frames_passed++;
        if (now - fpc_start > 1) {
            std::ostringstream strs;
            strs << "FPS: " ;
            strs << frames_passed/(now - fpc_start);
            fps_text = strs.str();;
            fpc_start = now;
            frames_passed = 0;
        }

        // Gambar ikan di posisi yang tepat.
        clear_screen();
        draw_text("G: Guppy, P: Piranha, F: Food, Esc: Quit, Space: Pause", 18, 10, 10, 0, 0, 0);
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
    }

    close();

    return 0;
}