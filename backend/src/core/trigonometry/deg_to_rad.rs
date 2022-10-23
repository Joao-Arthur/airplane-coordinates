use crate::core::precise_decimal::PreciseDecimal;

pub fn deg_to_rad(value: f64) -> f64 {
    return value * std::f64::consts::PI / 180.0;
}

pub fn new_deg_to_rad(value: PreciseDecimal) -> PreciseDecimal {
    let half_circle = PreciseDecimal::from_int(180);
    let pi = PreciseDecimal::from_str(super::consts::PI);

    return value * pi / half_circle;
}

#[cfg(test)]
mod test_deg_to_rad {
    use super::*;

    #[test]
    fn transform_deg_to_rad() {
        assert_eq!(
            new_deg_to_rad(PreciseDecimal::from_int(0)),
            PreciseDecimal::from_str("0")
        );
        assert_eq!(
            new_deg_to_rad(PreciseDecimal::from_int(45)),
            PreciseDecimal::from_str("0.7853981633974483096156608458")
        );
        assert_eq!(
            new_deg_to_rad(PreciseDecimal::from_int(90)),
            PreciseDecimal::from_str("1.5707963267948966192313216917")
        );
        assert_eq!(
            new_deg_to_rad(PreciseDecimal::from_int(135)),
            PreciseDecimal::from_str("2.3561944901923449288469825375")
        );
        assert_eq!(
            new_deg_to_rad(PreciseDecimal::from_int(180)),
            PreciseDecimal::from_str("3.1415926535897932384626433833")
        );
        assert_eq!(
            new_deg_to_rad(PreciseDecimal::from_int(225)),
            PreciseDecimal::from_str("3.9269908169872415480783042291")
        );
        assert_eq!(
            new_deg_to_rad(PreciseDecimal::from_int(270)),
            PreciseDecimal::from_str("4.712388980384689857693965075")
        );
        assert_eq!(
            new_deg_to_rad(PreciseDecimal::from_int(315)),
            PreciseDecimal::from_str("5.4977871437821381673096259206")
        );
        assert_eq!(
            new_deg_to_rad(PreciseDecimal::from_int(360)),
            PreciseDecimal::from_str("6.2831853071795864769252867667")
        );
    }
}
