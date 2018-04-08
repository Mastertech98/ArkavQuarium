// Anda tidak perlu melakukan perubahan pada file ini untuk memenuhi spek
// wajib. Namun, hal tersebut diperbolehkan.
#include "oop.hpp"

#include <map>
#include <iostream>
#include <chrono>

using namespace std::chrono;

high_resolution_clock::time_point start = high_resolution_clock::now();

double time_since_start()
{
    high_resolution_clock::time_point now = high_resolution_clock::now();
        return duration_cast<duration<double>>(now - start).count();
}

SDL_Window* sdlWindow;
std::map<std::string, SDL_Surface*> loadedSurfaces;
std::map<int, TTF_Font*> loadedFontSizes;
SDL_Surface* gScreenSurface = NULL;

SDL_DisplayMode current;

bool init()
{
    bool success = true;

    if( SDL_Init( SDL_INIT_VIDEO ) < 0 )
    {
        printf( "SDL could not initialize! SDL Error: %s\n", SDL_GetError() );
        success = false;
    }
    else
    {
        for (int i = 0; i < SDL_GetNumVideoDisplays(); i++) {
            int should_be_zero = SDL_GetCurrentDisplayMode(i, &current);

            if (should_be_zero != 0) {
                printf("Could not get display mode for video display #%d: %s", i, SDL_GetError());
                success = false;
            }
        }
        if(TTF_Init() == -1) {
            printf("TTF_Init: %s\n", TTF_GetError());
            success = false;
        }
        sdlWindow = SDL_CreateWindow( "ArkavQuarium", SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED, get_screen_width(), get_screen_height(), SDL_WINDOW_FULLSCREEN_DESKTOP );
        if( sdlWindow == NULL )
        {
            printf( "Window could not be created! SDL Error: %s\n", SDL_GetError() );
            success = false;
        }
        else
        {
            gScreenSurface = SDL_GetWindowSurface( sdlWindow );
        }
    }

    return success;
}

void close()
{
    for (auto const& x : loadedSurfaces)
    {
        SDL_FreeSurface( x.second );
    }

    for (auto const& x : loadedFontSizes)
    {
        TTF_CloseFont( x.second );
    }

    SDL_DestroyWindow( sdlWindow );
    sdlWindow = NULL;

    SDL_Quit();
}

SDL_Surface* loadSurface( std::string path )
{
    SDL_Surface* loadedSurface = IMG_Load( path.c_str() );
    if( loadedSurface == NULL )
    {
        printf( "Unable to load image %s! SDL Error: %s\n", path.c_str(), SDL_GetError() );
    }

    return loadedSurface;
}

void draw_image(std::string filename, int x, int y) {
    if (loadedSurfaces.count(filename) < 1) {
        loadedSurfaces[filename] = loadSurface(filename);
    }

    SDL_Surface* s = loadedSurfaces[filename];

    SDL_Rect dest;
    dest.x = x - s->w/2;
    dest.y = y - s->h/2;
    dest.w = s->w;
    dest.h = s->h;
    SDL_BlitSurface(s, NULL, gScreenSurface, &dest);
}

void draw_text(std::string text, int font_size, int x, int y, unsigned char r, unsigned char g, unsigned char b) {
    if (loadedFontSizes.count(font_size) < 1) {
        loadedFontSizes[font_size] = TTF_OpenFont(FONT_NAME, font_size);
    }

    TTF_Font* font = loadedFontSizes[font_size];
    SDL_Surface* result = TTF_RenderText_Blended(font, text.c_str(), {r, g, b});
    SDL_Rect dest;
    dest.x = x;
    dest.y = y;
    dest.w = result->w;
    dest.h = result->h;
    SDL_BlitSurface(result, NULL, gScreenSurface, &dest);
    SDL_FreeSurface(result);
}

void clear_screen() {
    SDL_FillRect(gScreenSurface, NULL, SDL_MapRGB(gScreenSurface->format, 255, 255, 255));
}

void update_screen() {
    SDL_UpdateWindowSurface(sdlWindow);
}

bool quit = false;
std::set<SDL_Keycode> pressedKeys;
std::set<SDL_Keycode> tappedKeys;
bool mouseButtonTapped;

void handle_input() {
    SDL_Event e;
    if (!tappedKeys.empty()) tappedKeys.clear();
    mouseButtonTapped = false;
    while( SDL_PollEvent( &e ) != 0 )
        {
            if ( e.type == SDL_QUIT ) {
                quit = true;
            } else if (e.type == SDL_KEYDOWN && !e.key.repeat) {
                pressedKeys.insert(e.key.keysym.sym);
                tappedKeys.insert(e.key.keysym.sym);
            } else if (e.type == SDL_KEYUP) {
                pressedKeys.erase(e.key.keysym.sym);
            } else if (e.type == SDL_MOUSEBUTTONDOWN) {
                mouseButtonTapped = true;
            }
        }
}

bool quit_pressed() {
    return quit;
}

const std::set<SDL_Keycode>& get_pressed_keys() {
    return pressedKeys;
}

const std::set<SDL_Keycode>& get_tapped_keys() {
    return tappedKeys;
}

bool get_mouse_button_tapped() {
    return mouseButtonTapped;
}

int get_screen_width() {
    return current.w;
}

int get_screen_height() {
    return current.h;
}