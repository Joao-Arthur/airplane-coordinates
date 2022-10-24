use rust_decimal::prelude::*;

use crate::core::math::MathOperations;
use crate::core::trigonometry::consts::*;

#[derive(Debug, Clone)]
pub struct PreciseDecimal {
    pub value: String,
}

impl PreciseDecimal {
    pub fn from_string(value: String) -> PreciseDecimal {
        PreciseDecimal { value }
    }

    pub fn from_str(value: &str) -> PreciseDecimal {
        PreciseDecimal {
            value: value.to_string(),
        }
    }

    pub fn from_int(value: isize) -> PreciseDecimal {
        PreciseDecimal {
            value: value.to_string(),
        }
    }
}

impl MathOperations<PreciseDecimal> for PreciseDecimal {
    fn sqrt(&self) -> PreciseDecimal {
        let decimal = Decimal::from_str(self.value.as_str()).unwrap();

        PreciseDecimal::from_string(decimal.sqrt().unwrap().to_string())
    }

    fn square(&self) -> PreciseDecimal {
        let decimal = Decimal::from_str(self.value.as_str()).unwrap();

        PreciseDecimal::from_string(decimal.powi(2).to_string())
    }

    fn cos(&self) -> PreciseDecimal {
        /*
            without these, the following error happens:
            ====
            thread has overflowed its stack
            fatal runtime error: stack overflow
            ====
            it appears to be a problem with the rust-decimal
            I tried to run this function in a separate thread
            with 4GB stack and it still overflows
        */
        match self.value.as_str() {
            AS_RAD_45 => PreciseDecimal::from_str("0.7071067811865475244008443621"),
            AS_RAD_135 => PreciseDecimal::from_str("-0.7071067811865475244008443621"),
            AS_RAD_225 => PreciseDecimal::from_str("-0.7071067811865475244008443621"),
            AS_RAD_315 => PreciseDecimal::from_str("0.7071067811865475244008443621"),
            _ => {
                let decimal = Decimal::from_str(self.value.as_str()).unwrap();
                PreciseDecimal::from_string(decimal.cos().to_string())
            }
        }
    }

    fn sin(&self) -> PreciseDecimal {
        /*
            without these, the following error happens:
            ====
            thread has overflowed its stack
            fatal runtime error: stack overflow
            ====
            it appears to be a problem with the rust-decimal
            I tried to run this function in a separate thread
            with 4GB stack and it still overflows
        */
        match self.value.as_str() {
            AS_RAD_45 => PreciseDecimal::from_str("0.7071067811865475244008443621"),
            AS_RAD_135 => PreciseDecimal::from_str("0.7071067811865475244008443621"),
            AS_RAD_225 => PreciseDecimal::from_str("-0.7071067811865475244008443621"),
            AS_RAD_315 => PreciseDecimal::from_str("-0.7071067811865475244008443621"),
            _ => {
                let decimal = Decimal::from_str(self.value.as_str()).unwrap();
                PreciseDecimal::from_string(decimal.sin().to_string())
            }
        }
    }
}

impl PartialEq for PreciseDecimal {
    fn eq(&self, other: &Self) -> bool {
        self.value == other.value
    }
}

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
mod test_precise_decimal {
    use super::*;

    #[test]
    fn from_values() {
        assert_eq!(
            PreciseDecimal::from_string(String::from("28.37185")),
            PreciseDecimal {
                value: "28.37185".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal::from_str("-1046.438682"),
            PreciseDecimal {
                value: "-1046.438682".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal::from_int(983),
            PreciseDecimal {
                value: "983".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal::from_int(-4),
            PreciseDecimal {
                value: "-4".to_string()
            }
        );
    }

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

    #[test]
    fn sqrt() {
        assert_eq!(
            PreciseDecimal::from_str("1").sqrt(),
            PreciseDecimal::from_str("1.0000000000000000000000000000")
        );
        assert_eq!(
            PreciseDecimal::from_str("2").sqrt(),
            PreciseDecimal::from_str("1.4142135623730950488016887242")
        );
        assert_eq!(
            PreciseDecimal::from_str("3").sqrt(),
            PreciseDecimal::from_str("1.7320508075688772935274463415")
        );
        assert_eq!(
            PreciseDecimal::from_str("4").sqrt(),
            PreciseDecimal::from_str("2")
        );
        assert_eq!(
            PreciseDecimal::from_str("8").sqrt(),
            PreciseDecimal::from_str("2.8284271247461900976033774484")
        );
    }

    #[test]
    fn square() {
        assert_eq!(
            PreciseDecimal::from_str("1").square(),
            PreciseDecimal::from_str("1")
        );
        assert_eq!(
            PreciseDecimal::from_str("1.4142135623730950488016887242").square(),
            PreciseDecimal::from_str("2.0000000000000000000000000000")
        );
        assert_eq!(
            PreciseDecimal::from_str("1.7320508075688772935274463415").square(),
            PreciseDecimal::from_str("3.0000000000000000000000000000")
        );
        assert_eq!(
            PreciseDecimal::from_str("2").square(),
            PreciseDecimal::from_str("4")
        );
        assert_eq!(
            PreciseDecimal::from_str("2.8284271247461900976033774484").square(),
            PreciseDecimal::from_str("8.000000000000000000000000000")
        );
    }

    #[test]
    fn sin() {
        assert_eq!(
            PreciseDecimal::from_str("0").sin(),
            PreciseDecimal::from_str("0")
        );
        assert_eq!(
            PreciseDecimal::from_str("1").sin(),
            PreciseDecimal::from_str("0.8414709848054038642624295038")
        );
        assert_eq!(
            PreciseDecimal::from_str("2").sin(),
            PreciseDecimal::from_str("0.9092974268256001903062739251")
        );
        assert_eq!(
            PreciseDecimal::from_str("3").sin(),
            PreciseDecimal::from_str("0.1411200080598672220992683907")
        );
        assert_eq!(
            PreciseDecimal::from_str("4").sin(),
            PreciseDecimal::from_str("-0.7568024952723602702785983780")
        );
        assert_eq!(
            PreciseDecimal::from_str("5").sin(),
            PreciseDecimal::from_str("-0.9589242746631378003461760450")
        );
        assert_eq!(
            PreciseDecimal::from_str("6").sin(),
            PreciseDecimal::from_str("-0.2794154981989258607202506132")
        );
        assert_eq!(
            PreciseDecimal::from_str("7").sin(),
            PreciseDecimal::from_str("0.6569865987166758570704634881")
        );
    }

    #[test]
    fn cos() {
        assert_eq!(
            PreciseDecimal::from_str("0").cos(),
            PreciseDecimal::from_str("1")
        );
        assert_eq!(
            PreciseDecimal::from_str("1").cos(),
            PreciseDecimal::from_str("0.5403023058680302458227001515")
        );
        assert_eq!(
            PreciseDecimal::from_str("2").cos(),
            PreciseDecimal::from_str("-0.4161468365471396956896160433")
        );
        assert_eq!(
            PreciseDecimal::from_str("3").cos(),
            PreciseDecimal::from_str("-0.9899924966004454571360214443")
        );
        assert_eq!(
            PreciseDecimal::from_str("4").cos(),
            PreciseDecimal::from_str("-0.6536436208616620954476562566")
        );
        assert_eq!(
            PreciseDecimal::from_str("5").cos(),
            PreciseDecimal::from_str("0.2836621854632262496748600387")
        );
        assert_eq!(
            PreciseDecimal::from_str("6").cos(),
            PreciseDecimal::from_str("0.9601702866503654655107475412")
        );
        assert_eq!(
            PreciseDecimal::from_str("7").cos(),
            PreciseDecimal::from_str("0.7539022543049938919232610909")
        );
    }
}
