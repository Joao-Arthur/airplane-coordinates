use std::f64::consts::PI;

pub fn deg_to_rad(value: f64) -> f64 {
    return value * PI / 180.0;
}

#[cfg(test)]
mod test_deg_to_rad {
    use super::*;

    #[test]
    fn should_transform_deg_to_rad() {
        assert_eq!(deg_to_rad(0.0), 0.0);
        assert_eq!(deg_to_rad(45.0), 0.7853981633974483);
        assert_eq!(deg_to_rad(90.0), 1.5707963267948966);
        assert_eq!(deg_to_rad(135.0), 2.356194490192345);
        assert_eq!(deg_to_rad(180.0), 3.141592653589793);
        assert_eq!(deg_to_rad(225.0), 3.9269908169872414);
        assert_eq!(deg_to_rad(270.0), 4.71238898038469);
        assert_eq!(deg_to_rad(315.0), 5.497787143782138);
        assert_eq!(deg_to_rad(360.0), 6.283185307179586);
    }
}
