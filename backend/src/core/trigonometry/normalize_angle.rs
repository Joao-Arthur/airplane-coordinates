use crate::core::precise_decimal::PreciseDecimal;

pub fn normalize_angle(angle: f64) -> f64 {
    return (angle % 360.0 + 360.0) % 360.0;
}

pub fn new_normalize_angle(angle: PreciseDecimal) -> PreciseDecimal {
    return (angle % PreciseDecimal::from_int(360) + PreciseDecimal::from_int(360))
        % PreciseDecimal::from_int(360);
}

#[cfg(test)]
mod test_normalize_angle {
    use super::*;

    #[test]
    fn normalize_angles_smaller_than_0() {
        assert_eq!(
            new_normalize_angle(PreciseDecimal::from_int(-100)),
            PreciseDecimal::from_int(260)
        );
        assert_eq!(
            new_normalize_angle(PreciseDecimal::from_int(-1)),
            PreciseDecimal::from_int(359)
        );
    }

    #[test]
    fn normalize_angles_greater_than_360() {
        assert_eq!(
            new_normalize_angle(PreciseDecimal::from_int(360)),
            PreciseDecimal::from_int(0)
        );
        assert_eq!(
            new_normalize_angle(PreciseDecimal::from_int(720)),
            PreciseDecimal::from_int(0)
        );
        assert_eq!(
            new_normalize_angle(PreciseDecimal::from_int(405)),
            PreciseDecimal::from_int(45)
        );
        assert_eq!(
            new_normalize_angle(PreciseDecimal::from_int(765)),
            PreciseDecimal::from_int(45),
        );
    }

    #[test]
    fn keep_the_angles_in_range() {
        assert_eq!(
            new_normalize_angle(PreciseDecimal::from_int(0)),
            PreciseDecimal::from_int(0)
        );
        assert_eq!(
            new_normalize_angle(PreciseDecimal::from_int(10)),
            PreciseDecimal::from_int(10)
        );
        assert_eq!(
            new_normalize_angle(PreciseDecimal::from_int(90)),
            PreciseDecimal::from_int(90),
        );
        assert_eq!(
            new_normalize_angle(PreciseDecimal::from_str("111.11")),
            PreciseDecimal::from_str("111.11")
        );
    }
}
