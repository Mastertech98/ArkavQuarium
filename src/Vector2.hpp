#ifndef VECTOR2_HPP
#define VECTOR2_HPP

#include <cmath>

#include <string>

struct Vector2 {
    double x, y;

    /// Default constructor
    Vector2();
    /// Constructor: x = _x, y = _y
    Vector2(double _x, double _y);
    /// Copy Constructor
    Vector2(const Vector2& other);

    /// Equality operator
    bool operator==(const Vector2& other) const;
    /// Inequality operator
    bool operator!=(const Vector2& other) const;

    /// Addition
    Vector2 operator+(const Vector2& other) const;
    /// Substraction
    Vector2 operator-(const Vector2& other) const;

    /// Return this vector2 with magnitude of 1
    Vector2 normalized() const;
    /// Return this vector2 distance to other vector2
    double distance(const Vector2& other) const;

    /// Friend: Vector2 times Double
    friend Vector2 operator*(Vector2 vector2, double k);
    /// Friend: Double times Vector2
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
