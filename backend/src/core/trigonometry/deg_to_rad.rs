pub fn deg_to_rad(value: f64) -> f64 {
    return value * 3.1415926535 / 180;
}

#[cfg(test)]
mod test_deg_to_rad {
    use super::*;

    #[test]
    fn should_transform_deg_to_rad() {
        assert_eq!(simplify_angle(-100.0), 260);
        assert_eq!(simplify_angle(-1.0), 359);
    });
}
