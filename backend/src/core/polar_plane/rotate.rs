use super::polar_point::PolarPoint;
use crate::core::trigonometry::normalize_angle::normalize_angle;

pub fn rotate(point: PolarPoint, angle: f64) -> PolarPoint {
    return PolarPoint {
        r: point.r,
        a: normalize_angle(point.a + angle),
    };
}

#[cfg(test)]
mod test_rotate {
    use super::*;

    #[test]
    fn expect_to_rotate() {
        assert_eq!(
            rotate(PolarPoint { r: 1.0, a: 300.0 }, 50.0),
            PolarPoint { r: 1.0, a: 350.0 }
        );
        assert_eq!(
            rotate(PolarPoint { r: 1.0, a: 200.0 }, 50.0),
            PolarPoint { r: 1.0, a: 250.0 }
        );
        assert_eq!(
            rotate(PolarPoint { r: 1.0, a: 111.11 }, 11.40),
            PolarPoint { r: 1.0, a: 122.51 }
        );
        assert_eq!(
            rotate(PolarPoint { r: 1.0, a: 34.02 }, 19.04),
            PolarPoint { r: 1.0, a: 53.06 }
        );
        assert_eq!(
            rotate(PolarPoint { r: 1.0, a: 60.0 }, -120.0),
            PolarPoint { r: 1.0, a: 300.0 }
        );
        assert_eq!(
            rotate(PolarPoint { r: 1.0, a: 60.0 }, -60.0),
            PolarPoint { r: 1.0, a: 0.0 }
        );
    }
}
