# Masukkan semua file cpp Anda
OBJS = main.cpp oop.cpp Aquarium.cpp AquariumObject.cpp Coin.cpp Creature.cpp Fish.cpp Food.cpp Guppy.cpp LinkedList.hpp Piranha.cpp Snail.cpp Vector2.cpp

CC = g++
COMPILER_FLAGS = -std=c++11 -Wall -O2
LINKER_FLAGS = -lSDL2 -lSDL2_image -lSDL2_ttf
OBJ_NAME = oopquarium
all : $(OBJS)
	$(CC) $(OBJS) $(COMPILER_FLAGS) $(LINKER_FLAGS) -o $(OBJ_NAME)
