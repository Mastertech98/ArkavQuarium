#ifndef IDESTRUCTIBLE_HPP
#define IDESTRUCTIBLE_HPP

class IDestructible {
    public:
        /// Abstract function of destruct
        void virtual destruct() = 0;
};

#endif