use crate::core::precise_decimal::PreciseDecimal;

#[derive(Debug, Clone)]
pub struct CartesianPoint {
    pub x: PreciseDecimal,
    pub y: PreciseDecimal,
}

impl PartialEq for CartesianPoint {
    fn eq(&self, other: &Self) -> bool {
        self.x == other.x && self.y == self.y
    }
}

impl std::ops::Add<CartesianPoint> for CartesianPoint {
    type Output = CartesianPoint;

    fn add(self, other: CartesianPoint) -> CartesianPoint {
        CartesianPoint {
            x: self.x + other.x,
            y: self.y + other.y,
        }
    }
}

impl std::ops::Sub<CartesianPoint> for CartesianPoint {
    type Output = CartesianPoint;

    fn sub(self, other: CartesianPoint) -> CartesianPoint {
        CartesianPoint {
            x: self.x - other.x,
            y: self.y - other.y,
        }
    }
}

impl std::ops::Mul<CartesianPoint> for CartesianPoint {
    type Output = CartesianPoint;

    fn mul(self, other: CartesianPoint) -> CartesianPoint {
        CartesianPoint {
            x: self.x * other.x,
            y: self.y * other.y,
        }
    }
}

#[cfg(test)]
mod test_cartesian_point {
    use super::*;

    #[test]
    fn sum() {
        assert_eq!(
            CartesianPoint {
                x: PreciseDecimal::from_int(4),
                y: PreciseDecimal::from_int(7)
            } + CartesianPoint {
                x: PreciseDecimal::from_int(2),
                y: PreciseDecimal::from_int(-3)
            },
            CartesianPoint {
                x: PreciseDecimal::from_int(6),
                y: PreciseDecimal::from_int(4)
            }
        );
        assert_eq!(
            CartesianPoint {
                x: PreciseDecimal::from_int(-1),
                y: PreciseDecimal::from_int(3)
            } + CartesianPoint {
                x: PreciseDecimal::from_int(2),
                y: PreciseDecimal::from_int(-3)
            },
            CartesianPoint {
                x: PreciseDecimal::from_int(1),
                y: PreciseDecimal::from_int(0)
            }
        );
        assert_eq!(
            CartesianPoint {
                x: PreciseDecimal::from_int(4),
                y: PreciseDecimal::from_int(7)
            } + CartesianPoint {
                x: PreciseDecimal::from_int(0),
                y: PreciseDecimal::from_int(0)
            },
            CartesianPoint {
                x: PreciseDecimal::from_int(4),
                y: PreciseDecimal::from_int(7)
            }
        );
    }

    #[test]
    fn subtract() {
        assert_eq!(
            CartesianPoint {
                x: PreciseDecimal::from_int(6),
                y: PreciseDecimal::from_int(4)
            } - CartesianPoint {
                x: PreciseDecimal::from_int(4),
                y: PreciseDecimal::from_int(7)
            },
            CartesianPoint {
                x: PreciseDecimal::from_int(2),
                y: PreciseDecimal::from_int(-3)
            },
        );
        assert_eq!(
            CartesianPoint {
                x: PreciseDecimal::from_int(1),
                y: PreciseDecimal::from_int(0)
            } - CartesianPoint {
                x: PreciseDecimal::from_int(-1),
                y: PreciseDecimal::from_int(3)
            },
            CartesianPoint {
                x: PreciseDecimal::from_int(2),
                y: PreciseDecimal::from_int(-3)
            },
        );
        assert_eq!(
            CartesianPoint {
                x: PreciseDecimal::from_int(4),
                y: PreciseDecimal::from_int(7)
            } - CartesianPoint {
                x: PreciseDecimal::from_int(4),
                y: PreciseDecimal::from_int(7)
            },
            CartesianPoint {
                x: PreciseDecimal::from_int(0),
                y: PreciseDecimal::from_int(0)
            },
        );
    }

    #[test]
    fn multiply() {
        assert_eq!(
            CartesianPoint {
                x: PreciseDecimal::from_int(4),
                y: PreciseDecimal::from_int(7)
            } * CartesianPoint {
                x: PreciseDecimal::from_int(2),
                y: PreciseDecimal::from_int(-3)
            },
            CartesianPoint {
                x: PreciseDecimal::from_int(8),
                y: PreciseDecimal::from_int(-21)
            }
        );
        assert_eq!(
            CartesianPoint {
                x: PreciseDecimal::from_int(-1),
                y: PreciseDecimal::from_int(3)
            } * CartesianPoint {
                x: PreciseDecimal::from_int(2),
                y: PreciseDecimal::from_int(-3)
            },
            CartesianPoint {
                x: PreciseDecimal::from_int(-2),
                y: PreciseDecimal::from_int(-9)
            }
        );
        assert_eq!(
            CartesianPoint {
                x: PreciseDecimal::from_int(-1),
                y: PreciseDecimal::from_int(3)
            } * CartesianPoint {
                x: PreciseDecimal::from_int(0),
                y: PreciseDecimal::from_int(0)
            },
            CartesianPoint {
                x: PreciseDecimal::from_int(0),
                y: PreciseDecimal::from_int(0)
            }
        );
    }
}
