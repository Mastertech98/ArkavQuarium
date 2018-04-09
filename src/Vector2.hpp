#ifndef VECTOR2_HPP
#define VECTOR2_HPP

#include <cmath>

#include <string>

struct Vector2 {
    double x, y;

    Vector2();
    Vector2(double _x, double _y);
    Vector2(const Vector2& other);

    bool operator!=(const Vector2& other) const;

    Vector2 operator+(const Vector2& other) const;
    Vector2 operator-(const Vector2& other) const;

    Vector2 normalized() const;
    double distance(const Vector2& other) const;

    friend Vector2 operator*(Vector2 vector2, double k);
    friend Vector2 operator*(double k, Vector2 vector2);

    static const Vector2 null;
    static const Vector2 zero;
    static const Vector2 right;
    static const Vector2 up;
    static const Vector2 left;
    static const Vector2 down;
    static Vector2 randomPosition(double x, double y);
    static Vector2 randomDirection();

    std::string toString();
};

#endif