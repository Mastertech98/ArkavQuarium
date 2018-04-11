#include "Vector2.hpp"
#include <cstdlib>
#include <cmath>
#include <ctime>

Vector2::Vector2() {
    x = 0;
    y = 0;
}

Vector2::Vector2(double _x, double _y) {
    x = _x;
    y = _y;
}

Vector2::Vector2(const Vector2& other) {
    x = other.x;
    y = other.y;
}

bool Vector2::operator==(const Vector2& other) const {
    return x == other.x || y == other.y;
}

bool Vector2::operator!=(const Vector2& other) const {
    return x != other.x || y != other.y;
}

Vector2 Vector2::operator+(const Vector2& other) const {
    return Vector2(x + other.x, y + other.y);
}

Vector2 Vector2::operator-(const Vector2& other) const {
    return Vector2(x - other.x, y - other.y);
}

Vector2 Vector2::normalized() const {
    return 1 / Vector2::zero.distance(*this) * *this;
}

double Vector2::distance(const Vector2& other) const {
    double dx = x - other.x;
    double dy = y - other.y;
    return sqrt(dx * dx + dy * dy);
}

Vector2 operator*(Vector2 vector2, double k) {
    vector2.x *= k;
    vector2.y *= k;
    return vector2;
}

Vector2 operator*(double k, Vector2 vector2) {
    vector2.x *= k;
    vector2.y *= k;
    return vector2;
}

const Vector2 Vector2::null = Vector2(-1, -1);
const Vector2 Vector2::zero = Vector2();
const Vector2 Vector2::right = Vector2(1, 0);
const Vector2 Vector2::left = Vector2(-1, 0);
const Vector2 Vector2::up = Vector2(0, -1);
const Vector2 Vector2::down = Vector2(0, 1);

Vector2 Vector2::randomPosition(double x, double y) {
    std::srand(time(0));
    return Vector2(static_cast <double> (std::rand()) / static_cast <double> (RAND_MAX / x), static_cast <double> (std::rand()) / static_cast <double> (RAND_MAX / y));
}

Vector2 Vector2::randomDirection() {
    std::srand(time(0));
    double rad = static_cast <double> (std::rand()) / static_cast <double> (RAND_MAX / M_PI / 2);
    return Vector2(cos(rad), sin(rad));
}

std::string Vector2::toString() {
    return "(" + std::to_string(x) + ", " + std::to_string(y) + ")";
}
