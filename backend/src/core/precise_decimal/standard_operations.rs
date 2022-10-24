use rust_decimal::prelude::*;

use super::PreciseDecimal;

impl std::ops::Add<PreciseDecimal> for PreciseDecimal {
    type Output = PreciseDecimal;

    fn add(self, other: PreciseDecimal) -> PreciseDecimal {
        let self_decimal = Decimal::from_str(self.value.as_str()).unwrap();
        let other_decimal = Decimal::from_str(other.value.as_str()).unwrap();

        PreciseDecimal::from_string((self_decimal + other_decimal).to_string())
    }
}

impl std::ops::Sub<PreciseDecimal> for PreciseDecimal {
    type Output = PreciseDecimal;

    fn sub(self, other: PreciseDecimal) -> PreciseDecimal {
        let self_decimal = Decimal::from_str(self.value.as_str()).unwrap();
        let other_decimal = Decimal::from_str(other.value.as_str()).unwrap();

        PreciseDecimal::from_string((self_decimal - other_decimal).to_string())
    }
}

impl std::ops::Mul<PreciseDecimal> for PreciseDecimal {
    type Output = PreciseDecimal;

    fn mul(self, other: PreciseDecimal) -> PreciseDecimal {
        let self_decimal = Decimal::from_str(self.value.as_str()).unwrap();
        let other_decimal = Decimal::from_str(other.value.as_str()).unwrap();

        PreciseDecimal::from_string((self_decimal * other_decimal).to_string())
    }
}

impl std::ops::Div<PreciseDecimal> for PreciseDecimal {
    type Output = PreciseDecimal;

    fn div(self, other: PreciseDecimal) -> PreciseDecimal {
        let self_decimal = Decimal::from_str(self.value.as_str()).unwrap();
        let other_decimal = Decimal::from_str(other.value.as_str()).unwrap();

        PreciseDecimal::from_string((self_decimal / other_decimal).to_string())
    }
}

impl std::ops::Rem<PreciseDecimal> for PreciseDecimal {
    type Output = PreciseDecimal;

    fn rem(self, other: PreciseDecimal) -> PreciseDecimal {
        let self_decimal = Decimal::from_str(self.value.as_str()).unwrap();
        let other_decimal = Decimal::from_str(other.value.as_str()).unwrap();

        PreciseDecimal::from_string((self_decimal % other_decimal).to_string())
    }
}

#[cfg(test)]
mod test_standard_operations {
    use super::*;

    #[test]
    fn sum() {
        assert_eq!(
            PreciseDecimal::from_int(4) + PreciseDecimal::from_int(2),
            PreciseDecimal::from_int(6)
        );
        assert_eq!(
            PreciseDecimal::from_int(-1) + PreciseDecimal::from_int(2),
            PreciseDecimal::from_int(1)
        );
        assert_eq!(
            PreciseDecimal::from_int(4) + PreciseDecimal::from_int(0),
            PreciseDecimal::from_int(4)
        );
        assert_eq!(
            PreciseDecimal::from_int(-1) + PreciseDecimal::from_int(0),
            PreciseDecimal::from_int(-1)
        );
        assert_eq!(
            PreciseDecimal::from_int(7) + PreciseDecimal::from_int(-3),
            PreciseDecimal::from_int(4)
        );
        assert_eq!(
            PreciseDecimal::from_int(3) + PreciseDecimal::from_int(-3),
            PreciseDecimal::from_int(0)
        );
        assert_eq!(
            PreciseDecimal::from_int(7) + PreciseDecimal::from_int(0),
            PreciseDecimal::from_int(7)
        );
        assert_eq!(
            PreciseDecimal::from_int(3) + PreciseDecimal::from_int(0),
            PreciseDecimal::from_int(3)
        );
    }

    #[test]
    fn subtract() {
        assert_eq!(
            PreciseDecimal::from_int(6) - PreciseDecimal::from_int(4),
            PreciseDecimal::from_int(2)
        );
        assert_eq!(
            PreciseDecimal::from_int(1) - PreciseDecimal::from_int(-1),
            PreciseDecimal::from_int(2),
        );
        assert_eq!(
            PreciseDecimal::from_int(4) - PreciseDecimal::from_int(4),
            PreciseDecimal::from_int(0),
        );
        assert_eq!(
            PreciseDecimal::from_int(-1) - PreciseDecimal::from_int(-1),
            PreciseDecimal::from_int(0),
        );
        assert_eq!(
            PreciseDecimal::from_int(4) - PreciseDecimal::from_int(7),
            PreciseDecimal::from_int(-3),
        );
        assert_eq!(
            PreciseDecimal::from_int(0) - PreciseDecimal::from_int(3),
            PreciseDecimal::from_int(-3),
        );
        assert_eq!(
            PreciseDecimal::from_int(7) - PreciseDecimal::from_int(7),
            PreciseDecimal::from_int(0),
        );
        assert_eq!(
            PreciseDecimal::from_int(3) - PreciseDecimal::from_int(3),
            PreciseDecimal::from_int(0),
        );
    }

    #[test]
    fn multiply() {
        assert_eq!(
            PreciseDecimal::from_int(4) * PreciseDecimal::from_int(2),
            PreciseDecimal::from_int(8)
        );
        assert_eq!(
            PreciseDecimal::from_int(-1) * PreciseDecimal::from_int(2),
            PreciseDecimal::from_int(-2)
        );
        assert_eq!(
            PreciseDecimal::from_int(4) * PreciseDecimal::from_int(0),
            PreciseDecimal::from_int(0)
        );
        assert_eq!(
            PreciseDecimal::from_int(-1) * PreciseDecimal::from_int(0),
            PreciseDecimal::from_int(0)
        );
        assert_eq!(
            PreciseDecimal::from_int(7) * PreciseDecimal::from_int(-3),
            PreciseDecimal::from_int(-21)
        );
        assert_eq!(
            PreciseDecimal::from_int(3) * PreciseDecimal::from_int(-3),
            PreciseDecimal::from_int(-9)
        );
        assert_eq!(
            PreciseDecimal::from_int(7) * PreciseDecimal::from_int(0),
            PreciseDecimal::from_int(0)
        );
        assert_eq!(
            PreciseDecimal::from_int(3) * PreciseDecimal::from_int(0),
            PreciseDecimal::from_int(0)
        );
    }

    #[test]
    fn divide() {
        assert_eq!(
            PreciseDecimal::from_int(8) / PreciseDecimal::from_int(4),
            PreciseDecimal::from_int(2),
        );
        assert_eq!(
            PreciseDecimal::from_int(-2) / PreciseDecimal::from_int(-1),
            PreciseDecimal::from_int(2),
        );
        assert_eq!(
            PreciseDecimal::from_int(0) / PreciseDecimal::from_int(4),
            PreciseDecimal::from_int(0),
        );
        assert_eq!(
            PreciseDecimal::from_int(0) / PreciseDecimal::from_int(-1),
            PreciseDecimal::from_int(0),
        );
        assert_eq!(
            PreciseDecimal::from_int(-21) / PreciseDecimal::from_int(7),
            PreciseDecimal::from_int(-3),
        );
        assert_eq!(
            PreciseDecimal::from_int(-9) / PreciseDecimal::from_int(3),
            PreciseDecimal::from_int(-3),
        );
        assert_eq!(
            PreciseDecimal::from_int(0) / PreciseDecimal::from_int(7),
            PreciseDecimal::from_int(0),
        );
        assert_eq!(
            PreciseDecimal::from_int(0) / PreciseDecimal::from_int(3),
            PreciseDecimal::from_int(0)
        );
    }

    #[test]
    fn division_remainder() {
        assert_eq!(
            PreciseDecimal::from_str("-100.277") % PreciseDecimal::from_int(360),
            PreciseDecimal::from_str("-100.277")
        );
        assert_eq!(
            PreciseDecimal::from_int(360) % PreciseDecimal::from_int(360),
            PreciseDecimal::from_int(0)
        );
        assert_eq!(
            PreciseDecimal::from_str("720.111") % PreciseDecimal::from_int(360),
            PreciseDecimal::from_str("0.111")
        );
        assert_eq!(
            PreciseDecimal::from_int(0) % PreciseDecimal::from_int(360),
            PreciseDecimal::from_int(0)
        );
    }

    #[test]
    fn precise_calculations() {
        assert_eq!(
            PreciseDecimal::from_str("0.1") + PreciseDecimal::from_str("0.2"),
            PreciseDecimal::from_str("0.3"),
        );
        assert_eq!(
            PreciseDecimal::from_str("0.1234567890123456789012345678901")
                + PreciseDecimal::from_str("0.1234321003123432100312343210036"),
            PreciseDecimal::from_str("0.2468888893246888889324688889"),
        );
        assert_eq!(
            PreciseDecimal::from_str("0.8937593473846237864238745")
                * PreciseDecimal::from_str("0.6986723567253716276345786345"),
            PreciseDecimal::from_str("0.6244449495825452115604125485"),
        );
        assert_eq!(
            PreciseDecimal::from_str("0.6244449495825452115604125485")
                / PreciseDecimal::from_str("0.8937593473846237864238745"),
            PreciseDecimal::from_str("0.6986723567253716276345786345"),
        );
        assert_eq!(
            PreciseDecimal::from_int(1)
                + PreciseDecimal::from_str("0.0000000000000000000000000001"),
            PreciseDecimal::from_str("1.0000000000000000000000000001"),
        );
        assert_eq!(
            PreciseDecimal::from_str("1.0000000000000000000000000001")
                - PreciseDecimal::from_str("0.0000000000000000000000000001"),
            PreciseDecimal::from_str("1.0000000000000000000000000000")
        );
    }
}
