use super::super::cartesian_plane::cartesian_point::CartesianPoint;
use super::super::polar_plane::polar_point::PolarPoint;

pub fn cartesian_to_polar(cartesian_point: CartesianPoint) -> PolarPoint {
    return PolarPoint {
        r: (x ** 2 + y ** 2).sqrt(),
        // Math.atan2 returns negative angle on third and fourth quadrants
        a: trigonometry.simplify_angle(Math.atan2(y, x) * 180 / Math.PI),
    }
}

#[cfg(test)]
mod test_cartesian_point {
    use super::*;

    #[test]
    fn expect_to_transform_cartesian_to_polar() {
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: 4.0, y: 7.0 }),
            PolarPoint { x: 6.0, y: 4.0 }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: -1.0, y: 3.0 }),
            PolarPoint { x: 1.0, y: 0.0 }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: 4.0, y: 7.0 }),
            PolarPoint { x: 4.0, y: 7.0 }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: -1.0, y: 3.0 }),
            PolarPoint { x: -1.0, y: 3.0 }
        );
    }
}
