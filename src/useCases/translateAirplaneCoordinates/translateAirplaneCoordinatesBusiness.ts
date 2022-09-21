import { cartesianPlane } from "../../core/cartesianPlane";
import { airplaneType } from "../../models/airplane";

type paramsType = {
    readonly airplanes: airplaneType[];
    readonly x: number;
    readonly y: number;
}

export function translateAirplaneCoordinatesBusiness({ airplanes, x, y }: paramsType): readonly airplaneType[] {
    return airplanes.map(airplane => ({
        ...airplane,
        ...cartesianPlane.translate({
            point: { x: airplane.x, y: airplane.y },
            factor: { x, y }
        })
    }))
} 