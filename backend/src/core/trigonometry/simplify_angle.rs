pub fn simplify_angle(angle: f64) -> f64 {
    return (angle % 360 + 360) % 360;
}

#[cfg(test)]
mod test_simplify_angle {
    use super::*;

    #[test]
    fn should_simplify_angles_smaller_tang_0() {
        assert_eq!(simplify_angle(-100.0), 260);
        assert_eq!(simplify_angle(-1.0), 359);
    });

    #[test]
    fn should_simplify_angles_greater_than_360() {
        assert_eq!(simplify_angle(360.0), 0.0);
        assert_eq!(simplify_angle(720.0), 0.0);
        assert_eq!(simplify_angle(405.0), 45.0);
        assert_eq!(simplify_angle(765.0), 45.0);
    });

    #[test]
    fn should_keep_the_angles_already_ok() {
        assert_eq!(simplify_angle(0.0), 0.0);
        assert_eq!(simplify_angle(10.0), 10.0);
        assert_eq!(simplify_angle(90.0), 90.0);
        assert_eq!(simplify_angle(111.11), 111.11);
    }
}
