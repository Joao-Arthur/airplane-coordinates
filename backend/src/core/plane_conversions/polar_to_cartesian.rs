use super::super::cartesian_plane::cartesian_point::CartesianPoint;
use super::super::polar_plane::polar_point::PolarPoint;

pub fn polar_to_cartesian(cartesian_point: PolarPoint) -> CartesianPoint {
    return CartesianPoint {
        x: radius * (angle * Math.PI / 180).cos(),
        y: radius * (angle * Math.PI / 180).sin(),
    }
}

#[cfg(test)]
mod test_cartesian_point {
    use super::*;

    #[test]
    fn expect_to_transform_polar_to_cartesian_on_the_four_axis() {
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 0.0 }),
            CartesianPoint { x: 1.0, y: 0.0 }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 90.0 }),
            CartesianPoint { x: 0.0, y: 1.0 }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 180.0 }),
            CartesianPoint { x: -1.0, y: 0.0 }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 270.0 }),
            CartesianPoint { x: 0.0, y: -1.0 }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 360.0 }),
            CartesianPoint { x: 1.0, y: 0.0 }
        );
    }

    #[test]
    fn expect_to_transform_polar_to_cartesian_inbetween_the_four_axis() {
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 45.0 }),
            CartesianPoint { x: 0.7071067812, y: 0.7071067812 }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 135.0 }),
            CartesianPoint { x: -0.7071067812, y: 0.7071067812 }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 225.0 }),
            CartesianPoint { x: -0.7071067812, y: -0.7071067812 }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 315.0 }),
            CartesianPoint { x: 0.7071067812, y: -0.7071067812 }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 405.0 }),
            CartesianPoint { x: 0.7071067812, y: 0.7071067812 }
        );
    }

    #[test]
    fn expect_to_transform_polar_to_cartesian_at_the_starting_point() {
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 0.0, a: 0.0 }),
            CartesianPoint { x: 0.0, y: 0.0 }
        );
    }
}