import { useRef } from "react";
import { AirplanesImplementation } from "../../implementations/AirplanesImplementation";
import { airplaneType } from "../../models/airplane";


export function useAirplanes() {
    const airplanesImplementation = useRef(new AirplanesImplementation());

    function add(airplaneParams: { x: number; y: number; radius: number; angle: number; speed: number; direction: number; }) {
        return airplanesImplementation.current.addAirplane(airplaneParams);
    }

    function getCloseToAirport(maxDistance: number) {
        return airplanesImplementation.current.getAirplanesCloseToAirport(maxDistance);
    }

    function getCloseToEachOther(maxDistance: number) {
        return airplanesImplementation.current.getAirplanesCloseToEachOther(maxDistance);
    }

    function getInRouteOfCollision(maxTime: number) {
        return airplanesImplementation.current.getAirplanesInRouteOfCollision(maxTime);
    }

    function rotateCoordinates(
        selectedIds: readonly string[],
        angle: number,
        centerOfRotationX: number,
        centerOfRotationY: number
    ) {
        return airplanesImplementation.current.rotateAirplanesCoordinates(
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
        return airplanesImplementation.current.scalonateAirplanesCoordinates(
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
        return airplanesImplementation.current.translateAirplanesCoordinates(
            selectedIds,
            x,
            y
        );
    }

    function onLogUpdated(callback: (logs: readonly string[]) => void) {
        airplanesImplementation.current.onLogUpdated(callback);
    }

    function onRepositoryUpdated(callback: (airplanes: readonly airplaneType[]) => void) {
        airplanesImplementation.current.onRepositoryUpdated(callback);
    }

    return {
        add,
        getCloseToAirport,
        getCloseToEachOther,
        getInRouteOfCollision,
        rotateCoordinates,
        scalonateCoordinates,
        translateCoordinates,
        onLogUpdated,
        onRepositoryUpdated
    };
}