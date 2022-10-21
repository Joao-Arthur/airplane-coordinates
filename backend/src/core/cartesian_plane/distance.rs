use super::cartesian_point::CartesianPoint;

pub fn distance(a: CartesianPoint, b: CartesianPoint) -> f64 {
    let delta_x = a.x - b.x;
    let delta_y = a.y - b.y;
    return (delta_x.powi(2) + delta_y.powi(2)).sqrt();
}

#[cfg(test)]
mod test_distance {
    use super::*;

    #[test]
    fn in_the_same_point() {
        assert_eq!(
            distance(
                CartesianPoint { x: 0.0, y: 0.0 },
                CartesianPoint { x: 0.0, y: 0.0 },
            ),
            0.0
        );
        assert_eq!(
            distance(
                CartesianPoint { x: 1.0, y: 1.0 },
                CartesianPoint { x: 1.0, y: 1.0 },
            ),
            0.0
        );
    }

    #[test]
    fn in_the_x_axis() {
        assert_eq!(
            distance(
                CartesianPoint { x: -10.0, y: 5.0 },
                CartesianPoint { x: 20.0, y: 5.0 },
            ),
            30.0
        );
    }

    #[test]
    fn in_the_y_axis() {
        assert_eq!(
            distance(
                CartesianPoint { x: 5.0, y: 10.0 },
                CartesianPoint { x: 5.0, y: -20.0 },
            ),
            30.0
        );
    }

    #[test]
    fn in_the_x_and_y_axis() {
        assert_eq!(
            distance(
                CartesianPoint { x: 0.0, y: 0.0 },
                CartesianPoint { x: 1.0, y: 1.0 },
            ),
            2f64.sqrt()
        );
        assert_eq!(
            distance(
                CartesianPoint { x: -1.0, y: -1.0 },
                CartesianPoint { x: 1.0, y: 1.0 },
            ),
            8f64.sqrt()
        );
    }
}
