import { AirplanesImplementation } from "../../implementations/AirplanesImplementation";

export function useAirplanes() {
    const airplanesImplementation = new AirplanesImplementation();

    function add(airplaneParams: { x: number; y: number; radius: number; angle: number; speed: number; direction: number; }) {
        return airplanesImplementation.addAirplane(airplaneParams);
    }

    function getCloseToAirport(maxDistance: number) {
        return airplanesImplementation.getAirplanesCloseToAirport(maxDistance);
    }

    function getCloseToEachOther(maxDistance: number) {
        return airplanesImplementation.getAirplanesCloseToEachOther(maxDistance);
    }

    function getInRouteOfCollision(maxTime: number) {
        return airplanesImplementation.getAirplanesInRouteOfCollision(maxTime);
    }

    function rotateCoordinates(
        selectedIds: readonly string[],
        angle: number,
        centerOfRotationX: number,
        centerOfRotationY: number
    ) {
        return airplanesImplementation.rotateAirplanesCoordinates(
            selectedIds,
            angle,
            centerOfRotationX,
            centerOfRotationY
        );
    }

    function scalonateCoordinates(
        selectedIds: readonly string[],
        x: number,
        y: number,
    ) {
        return airplanesImplementation.scalonateAirplanesCoordinates(
            selectedIds,
            x,
            y,
        );
    }

    function translateCoordinates(
        selectedIds: readonly string[],
        x: number,
        y: number,
    ) {
        return airplanesImplementation.translateAirplanesCoordinates(
            selectedIds,
            x,
            y
        );
    }

    return {
        add,
        getCloseToAirport,
        getCloseToEachOther,
        getInRouteOfCollision,
        rotateCoordinates,
        scalonateCoordinates,
        translateCoordinates
    };
}