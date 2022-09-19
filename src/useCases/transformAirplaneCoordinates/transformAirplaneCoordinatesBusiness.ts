import { airplaneType } from "../../models/airplane";

type paramsType = {
    readonly airplanes: airplaneType[];
    readonly x: number;
    readonly y: number;
}

export function transformAirplaneCoordinatesBusiness({ airplanes, x, y }: paramsType): readonly airplaneType[] {
    return airplanes.map(airplane => ({
        ...airplane,
        x: airplane.x + x,
        y: airplane.y + y
    }))
} 