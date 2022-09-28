import { useRef } from 'react';
import { useDidMount } from 'rooks';
import {
    AirplaneGateway,
    gatewayAddAirplaneParamsType,
    gatewayAirplanesCloseToAirportParamsType,
    gatewayAirplanesCloseToEachOtherParamsType,
    gatewayAirplanesInRouteOfCollisionParamsType,
    gatewayRotateAirplaneCoordinatesParamsType,
    gatewayScalonateAirplaneCoordinatesParamsType,
    gatewayTranslateAirplaneCoordinatesParamsType
} from '../../features/airplane/gateways';
import { airplaneType } from '../../features/airplane/models';
import { messageType } from '../../features/logger/model';
import { useAirplaneStore } from './airplanesStore';

export function useAirplanes() {
    const airplaneGateway = useRef((window as any).airplaneGateway as AirplaneGateway);
    const { setAirplanes, setReports } = useAirplaneStore(state => state);

    function add(addAirplaneParams: gatewayAddAirplaneParamsType) {
        return airplaneGateway.current.addAirplane(addAirplaneParams);
    }

    function getCloseToAirport(airplanesCloseToAirportParams: gatewayAirplanesCloseToAirportParamsType) {
        return airplaneGateway.current.getAirplanesCloseToAirport(airplanesCloseToAirportParams);
    }

    function getCloseToEachOther(airplanesCloseToEachOtherParams: gatewayAirplanesCloseToEachOtherParamsType) {
        return airplaneGateway.current.getAirplanesCloseToEachOther(airplanesCloseToEachOtherParams);
    }

    function getInRouteOfCollision(airplanesInRouteOfCollisionParams: gatewayAirplanesInRouteOfCollisionParamsType) {
        return airplaneGateway.current.getAirplanesInRouteOfCollision(airplanesInRouteOfCollisionParams);
    }

    function rotateCoordinates(rotateAirplaneCoordinatesParams: gatewayRotateAirplaneCoordinatesParamsType) {
        return airplaneGateway.current.rotateAirplanesCoordinates(rotateAirplaneCoordinatesParams);
    }

    function scalonateCoordinates(scalonateAirplaneCoordinatesParams: gatewayScalonateAirplaneCoordinatesParamsType) {
        return airplaneGateway.current.scalonateAirplanesCoordinates(scalonateAirplaneCoordinatesParams);
    }

    function translateCoordinates(translateAirplaneCoordinatesParams: gatewayTranslateAirplaneCoordinatesParamsType) {
        return airplaneGateway.current.translateAirplanesCoordinates(translateAirplaneCoordinatesParams);
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
    } as const;
}