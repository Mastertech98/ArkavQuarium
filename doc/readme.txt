Untuk dapat menjalankan program yang menggunakan *library* ini, diperlukan
instalasi tiga *library*, yaitu:

 - SDL2
 - SDL2_Image
 - SDL2_TTF

Pada Ubuntu, ketiga *library* tersebut dapat diinstall dengan perintah berikut:

    apt-get install libsdl2-dev libsdl2-image-dev libsdl2-ttf-dev

Pada Fedora, ketiga *library* tersebut dapat diinstall dengan perintah berikut:

    yum install SDL2-devel SDL2_image-devel SDL2_ttf-devel

Untuk sistem lain, dapat mengikuti instruksi di halaman-halaman berikut:
 - [SDL2](http://lazyfoo.net/tutorials/SDL/01_hello_SDL/index.php)
 - [SDL2_Image](https://www.libsdl.org/projects/SDL_image/)
 - [SDL2_TTF](https://www.libsdl.org/projects/SDL_ttf/)

Disediakan sebuah Makefile sederhana untuk mengcompile program.
 
Untuk menjalankan program, dibutuhkan file gambar berikut:
 - background
 - buyegg
 - buyguppy
 - buypiranha
 - coin
 - food
 - guppy10
 - guppy11
 - guppy20
 - guppy21
 - guppy30
 - guppy31
 - piranha0
 - piranha1
 - play
 - snail0
 - snail1
Untuk menjalankan program, dibutuhkan file font berikut:
 - OpenSans-Regular.ttf

Program dapat dijalankan dengan mengeksekusi file oopquarium dengan file-file yang disebutkan sebelumnya dalam direktori yang sama.