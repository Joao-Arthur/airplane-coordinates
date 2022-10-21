pub fn normalize_angle(angle: f64) -> f64 {
    return (angle % 360.0 + 360.0) % 360.0;
}

#[cfg(test)]
mod test_normalize_angle {
    use super::*;

    #[test]
    fn normalize_angles_smaller_than_0() {
        assert_eq!(normalize_angle(-100.0), 260.0);
        assert_eq!(normalize_angle(-1.0), 359.0);
    }

    #[test]
    fn normalize_angles_greater_than_360() {
        assert_eq!(normalize_angle(360.0), 0.0);
        assert_eq!(normalize_angle(720.0), 0.0);
        assert_eq!(normalize_angle(405.0), 45.0);
        assert_eq!(normalize_angle(765.0), 45.0);
    }

    #[test]
    fn keep_the_angles_in_range() {
        assert_eq!(normalize_angle(0.0), 0.0);
        assert_eq!(normalize_angle(10.0), 10.0);
        assert_eq!(normalize_angle(90.0), 90.0);
        assert_eq!(normalize_angle(111.11), 111.11000000000001);
    }
}
