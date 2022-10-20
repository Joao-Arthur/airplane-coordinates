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
mod test_cartesian_to_polar {
    use super::*;

    #[test]
    fn expect_to_transform_cartesian_to_polar_on_the_four_axis() {
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: 1.0, y: 0.0 }),
            PolarPoint { r: 1.0, a: 0.0 }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: 0.0, y: 1.0 }),
            PolarPoint { r: 1.0, a: 90.0 }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: -1.0, y: 0.0 }),
            PolarPoint { r: 1.0, a: 180.0 }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: 0.0, y: -1.0 }),
            PolarPoint { r: 1.0, a: 270.0 }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: 1.0, y: 0.0 }),
            PolarPoint { r: 1.0, a: 360.0 }
        );
    }

    #[test]
    fn expect_to_transform_cartesian_to_polar_inbetween_the_four_axis() {
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: 0.7071067812, y: 0.7071067812 }),
            PolarPoint { r: 1.0, a: 45.0 }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: -0.7071067812, y: 0.7071067812 }),
            PolarPoint { r: 1.0, a: 135.0 }
        );
        assert_eq!(
            cartesian_to_polar( CartesianPoint { x: -0.7071067812, y: -0.7071067812 }),
            PolarPoint { r: 1.0, a: 225.0 }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: 0.7071067812, y: -0.7071067812 }),
            PolarPoint { r: 1.0, a: 315.0 }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: 0.7071067812, y: 0.7071067812 }),
            PolarPoint { r: 1.0, a: 405.0 }
        );
    }

    #[test]
    fn expect_to_transform_cartesian_to_polar_at_the_starting_point() {
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: 0.0, y: 0.0 }),
            PolarPoint { r: 0.0, a: 0.0 }
        );
    }
}
