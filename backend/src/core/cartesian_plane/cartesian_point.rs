use crate::core::precise_decimal::PreciseDecimal;

#[derive(Debug)]
pub struct CartesianPoint {
    pub x: f64,
    pub y: f64,
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

impl std::ops::Mul<CartesianPoint> for CartesianPoint {
    type Output = CartesianPoint;

    fn mul(self, other: CartesianPoint) -> CartesianPoint {
        CartesianPoint {
            x: self.x * other.x,
            y: self.y * other.y,
        }
    }
}

#[derive(Debug)]
pub struct NewCartesianPoint {
    pub x: PreciseDecimal,
    pub y: PreciseDecimal,
}

impl PartialEq for NewCartesianPoint {
    fn eq(&self, other: &Self) -> bool {
        self.x == other.x && self.y == self.y
    }
}

impl std::ops::Add<NewCartesianPoint> for NewCartesianPoint {
    type Output = NewCartesianPoint;

    fn add(self, other: NewCartesianPoint) -> NewCartesianPoint {
        NewCartesianPoint {
            x: self.x + other.x,
            y: self.y + other.y,
        }
    }
}

impl std::ops::Mul<NewCartesianPoint> for NewCartesianPoint {
    type Output = NewCartesianPoint;

    fn mul(self, other: NewCartesianPoint) -> NewCartesianPoint {
        NewCartesianPoint {
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
            NewCartesianPoint {
                x: PreciseDecimal::from_int(4),
                y: PreciseDecimal::from_int(7)
            } + NewCartesianPoint {
                x: PreciseDecimal::from_int(2),
                y: PreciseDecimal::from_int(-3)
            },
            NewCartesianPoint {
                x: PreciseDecimal::from_int(6),
                y: PreciseDecimal::from_int(4)
            }
        );
        assert_eq!(
            NewCartesianPoint {
                x: PreciseDecimal::from_int(-1),
                y: PreciseDecimal::from_int(3)
            } + NewCartesianPoint {
                x: PreciseDecimal::from_int(2),
                y: PreciseDecimal::from_int(-3)
            },
            NewCartesianPoint {
                x: PreciseDecimal::from_int(1),
                y: PreciseDecimal::from_int(0)
            }
        );
        assert_eq!(
            NewCartesianPoint {
                x: PreciseDecimal::from_int(4),
                y: PreciseDecimal::from_int(7)
            } + NewCartesianPoint {
                x: PreciseDecimal::from_int(0),
                y: PreciseDecimal::from_int(0)
            },
            NewCartesianPoint {
                x: PreciseDecimal::from_int(4),
                y: PreciseDecimal::from_int(7)
            }
        );
    }

    #[test]
    fn multiply() {
        assert_eq!(
            NewCartesianPoint {
                x: PreciseDecimal::from_int(4),
                y: PreciseDecimal::from_int(7)
            } * NewCartesianPoint {
                x: PreciseDecimal::from_int(2),
                y: PreciseDecimal::from_int(-3)
            },
            NewCartesianPoint {
                x: PreciseDecimal::from_int(8),
                y: PreciseDecimal::from_int(-21)
            }
        );
        assert_eq!(
            NewCartesianPoint {
                x: PreciseDecimal::from_int(-1),
                y: PreciseDecimal::from_int(3)
            } * NewCartesianPoint {
                x: PreciseDecimal::from_int(2),
                y: PreciseDecimal::from_int(-3)
            },
            NewCartesianPoint {
                x: PreciseDecimal::from_int(-2),
                y: PreciseDecimal::from_int(-9)
            }
        );
        assert_eq!(
            NewCartesianPoint {
                x: PreciseDecimal::from_int(-1),
                y: PreciseDecimal::from_int(3)
            } * NewCartesianPoint {
                x: PreciseDecimal::from_int(0),
                y: PreciseDecimal::from_int(0)
            },
            NewCartesianPoint {
                x: PreciseDecimal::from_int(0),
                y: PreciseDecimal::from_int(0)
            }
        );
    }
}
