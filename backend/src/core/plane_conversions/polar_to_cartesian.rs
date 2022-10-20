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
    fn expect_to_transform_polar_to_cartesian() {
        assert_eq!(
            polar_to_cartesian(PolarPoint { x: 4.0, y: 7.0 }),
            CartesianPoint { x: 6.0, y: 4.0 }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { x: -1.0, y: 3.0 }),
            CartesianPoint { x: 1.0, y: 0.0 }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { x: 4.0, y: 7.0 }),
            CartesianPoint { x: 4.0, y: 7.0 }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { x: -1.0, y: 3.0 }),
            CartesianPoint { x: -1.0, y: 3.0 }
        );
}
