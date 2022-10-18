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
        return CartesianPoint {
            x: self.x + other.x,
            y: self.y + other.y,
        };
    }
}

impl std::ops::Mul<CartesianPoint> for CartesianPoint {
    type Output = CartesianPoint;

    fn mul(self, other: CartesianPoint) -> CartesianPoint {
        return CartesianPoint {
            x: self.x * other.x,
            y: self.y * other.y,
        };
    }
}

#[cfg(test)]
mod test_cartesian_point {
    use super::*;

    #[test]
    fn expect_to_sum_correctly() {
        assert_eq!(
            CartesianPoint { x: 4.0, y: 7.0 } + CartesianPoint { x: 2.0, y: -3.0 },
            CartesianPoint { x: 6.0, y: 4.0 }
        );
        assert_eq!(
            CartesianPoint { x: -1.0, y: 3.0 } + CartesianPoint { x: 2.0, y: -3.0 },
            CartesianPoint { x: 1.0, y: 0.0 }
        );
        assert_eq!(
            CartesianPoint { x: 4.0, y: 7.0 } + CartesianPoint { x: 0.0, y: 0.0 },
            CartesianPoint { x: 4.0, y: 7.0 }
        );
        assert_eq!(
            CartesianPoint { x: -1.0, y: 3.0 } + CartesianPoint { x: 0.0, y: 0.0 },
            CartesianPoint { x: -1.0, y: 3.0 }
        );
    }

    #[test]
    fn expect_to_multiply_correctly() {
        assert_eq!(
            CartesianPoint { x: 4.0, y: 7.0 } * CartesianPoint { x: 2.0, y: -3.0 },
            CartesianPoint { x: 8.0, y: -21.0 }
        );
        assert_eq!(
            CartesianPoint { x: -1.0, y: 3.0 } * CartesianPoint { x: 2.0, y: -3.0 },
            CartesianPoint { x: -2.0, y: -9.0 }
        );
        assert_eq!(
            CartesianPoint { x: 4.0, y: 7.0 } * CartesianPoint { x: 0.0, y: 0.0 },
            CartesianPoint { x: 0.0, y: 0.0 }
        );
        assert_eq!(
            CartesianPoint { x: -1.0, y: 3.0 } * CartesianPoint { x: 0.0, y: 0.0 },
            CartesianPoint { x: 0.0, y: 0.0 }
        );
    }
}
