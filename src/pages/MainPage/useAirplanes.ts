import { useRef, useState } from 'react';
import { useDidMount } from 'rooks';
import { AirplaneGateway } from '../../features/airplane/gateways';
import { airplaneType } from '../../features/airplane/models';
import { messageType } from '../../features/logger/model';

export function useAirplanes() {
    const airplaneGateway = useRef(new AirplaneGateway());
    const [airplanes, setAirplanes] = useState<readonly airplaneType[]>([]);
    const [reports, setReports] = useState<readonly messageType[]>([]);

    function add(airplaneParams: { x: number; y: number; radius: number; angle: number; speed: number; direction: number; }) {
        return airplaneGateway.current.addAirplane(airplaneParams);
    }

    function getCloseToAirport(maxDistance: number) {
        return airplaneGateway.current.getAirplanesCloseToAirport(maxDistance);
    }

    function getCloseToEachOther(maxDistance: number) {
        return airplaneGateway.current.getAirplanesCloseToEachOther(maxDistance);
    }

    function getInRouteOfCollision(maxTime: number) {
        return airplaneGateway.current.getAirplanesInRouteOfCollision(maxTime);
    }

    function rotateCoordinates(
        selectedIds: readonly string[],
        angle: number,
        centerOfRotationX: number,
        centerOfRotationY: number
    ) {
        return airplaneGateway.current.rotateAirplanesCoordinates(
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
        return airplaneGateway.current.scalonateAirplanesCoordinates(
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
        return airplaneGateway.current.translateAirplanesCoordinates(
            selectedIds,
            x,
            y
        );
    }

    function onLogUpdated(callback: (logs: readonly messageType[]) => void) {
        airplaneGateway.current.onLogUpdated(callback);
    }

    function onRepositoryUpdated(callback: (airplanes: readonly airplaneType[]) => void) {
        airplaneGateway.current.onRepositoryUpdated(callback);
    }

    useDidMount(() => {
        onLogUpdated(setReports);
    });

    useDidMount(() => {
        onRepositoryUpdated(setAirplanes);
    });

    return {
        add,
        getCloseToAirport,
        getCloseToEachOther,
        getInRouteOfCollision,
        rotateCoordinates,
        scalonateCoordinates,
        translateCoordinates,
        airplanes,
        reports,
    };
}