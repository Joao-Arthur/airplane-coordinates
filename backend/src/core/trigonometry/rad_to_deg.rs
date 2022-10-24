use crate::core::precise_decimal::PreciseDecimal;

use super::consts::PI;

pub fn rad_to_deg(value: PreciseDecimal) -> PreciseDecimal {
    let half_circle = PreciseDecimal::from_int(180);
    let pi = PreciseDecimal::from_str(PI);

    value * half_circle / pi
}

#[cfg(test)]
mod test_rad_to_deg {
    use super::*;

    #[test]
    fn transform() {
        assert_eq!(
            rad_to_deg(PreciseDecimal::from_str("0"),),
            PreciseDecimal::from_int(0)
        );
        assert_eq!(
            rad_to_deg(PreciseDecimal::from_str("0.7853981633974483096156608458")),
            PreciseDecimal::from_str("44.999999999999999999999999997")
        );
        assert_eq!(
            rad_to_deg(PreciseDecimal::from_str("1.5707963267948966192313216917")),
            PreciseDecimal::from_str("90.0000000000000000000")
        );
        assert_eq!(
            rad_to_deg(PreciseDecimal::from_str("2.3561944901923449288469825375")),
            PreciseDecimal::from_str("135.0000000000000000000")
        );
        assert_eq!(
            rad_to_deg(PreciseDecimal::from_str("3.1415926535897932384626433833")),
            PreciseDecimal::from_str("180.0000000000000000000")
        );
        assert_eq!(
            rad_to_deg(PreciseDecimal::from_str("3.9269908169872415480783042291")),
            PreciseDecimal::from_str("225.0000000000000000000")
        );
        assert_eq!(
            rad_to_deg(PreciseDecimal::from_str("4.712388980384689857693965075")),
            PreciseDecimal::from_str("270.0000000000000000000")
        );
        assert_eq!(
            rad_to_deg(PreciseDecimal::from_str("5.4977871437821381673096259206")),
            PreciseDecimal::from_str("314.99999999999999999999999999")
        );
        assert_eq!(
            rad_to_deg(PreciseDecimal::from_str("6.2831853071795864769252867667")),
            PreciseDecimal::from_str("360.0000000000000000000")
        );
    }
}
