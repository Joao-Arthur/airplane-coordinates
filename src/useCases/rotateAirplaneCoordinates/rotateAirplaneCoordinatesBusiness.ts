import { airplaneType } from "../../models/airplane";

type paramsType = {
    readonly airplanes: readonly airplaneType[];
    readonly angle: number;
    readonly centerOfRotationX: number;
    readonly centerOfRotationY: number;
}

export function rotateAirplaneCoordinatesBusiness({
    airplanes,
    angle,
    centerOfRotationX,
    centerOfRotationY,
}: paramsType): readonly airplaneType[] {

}