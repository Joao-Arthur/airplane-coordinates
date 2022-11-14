import { useContext } from 'react';
import { useDidMount } from 'rooks';
import {
    gatewayAddAirplaneParamsType,
    gatewayDeleteAirplaneParamsType,
    gatewayAirplanesCloseToAirportParamsType,
    gatewayAirplanesCloseToEachOtherParamsType,
    gatewayAirplanesInRouteOfCollisionParamsType,
    gatewayRotateAirplaneCoordinatesParamsType,
    gatewayScalonateAirplaneCoordinatesParamsType,
    gatewayTranslateAirplaneCoordinatesParamsType,
} from '../../features/airplane/gateways';
import { airplaneType } from '../../features/airplane/models';
import { messageType } from '../../features/logger/model';
import { AirplaneContext } from './AirplaneContext';
import { useAirplaneStore } from './airplanesStore';

export function useAirplanes() {
    const { airplaneGateway } = useContext(AirplaneContext);
    const { setAirplanes, setReports, unselectAirplane } = useAirplaneStore();

    function add(addAirplaneParams: gatewayAddAirplaneParamsType) {
        return airplaneGateway.addAirplane(addAirplaneParams);
    }

    function deleteAiplanes(deleteAirplaneParams: gatewayDeleteAirplaneParamsType) {
        airplaneGateway.deleteAirplanes(deleteAirplaneParams);
        for (const id of deleteAirplaneParams.selectedIds)
            unselectAirplane(id);
    }

    function getCloseToAirport(airplanesCloseToAirportParams: gatewayAirplanesCloseToAirportParamsType) {
        return airplaneGateway.getAirplanesCloseToAirport(airplanesCloseToAirportParams);
    }

    function getCloseToEachOther(airplanesCloseToEachOtherParams: gatewayAirplanesCloseToEachOtherParamsType) {
        return airplaneGateway.getAirplanesCloseToEachOther(airplanesCloseToEachOtherParams);
    }

    function getInRouteOfCollision(airplanesInRouteOfCollisionParams: gatewayAirplanesInRouteOfCollisionParamsType) {
        return airplaneGateway.getAirplanesInRouteOfCollision(airplanesInRouteOfCollisionParams);
    }

    function rotateCoordinates(rotateAirplaneCoordinatesParams: gatewayRotateAirplaneCoordinatesParamsType) {
        return airplaneGateway.rotateAirplanesCoordinates(rotateAirplaneCoordinatesParams);
    }

    function scalonateCoordinates(scalonateAirplaneCoordinatesParams: gatewayScalonateAirplaneCoordinatesParamsType) {
        return airplaneGateway.scalonateAirplanesCoordinates(scalonateAirplaneCoordinatesParams);
    }

    function translateCoordinates(translateAirplaneCoordinatesParams: gatewayTranslateAirplaneCoordinatesParamsType) {
        return airplaneGateway.translateAirplanesCoordinates(translateAirplaneCoordinatesParams);
    }

    function onLogUpdated(callback: (logs: readonly messageType[]) => void) {
        airplaneGateway.onLogUpdated(callback);
    }

    function onRepositoryUpdated(callback: (airplanes: readonly airplaneType[]) => void) {
        airplaneGateway.onRepositoryUpdated(callback);
    }

    function clearLogs() {
        airplaneGateway.clearLogs();
    }

    useDidMount(() => {
        onLogUpdated(setReports);
    });

    useDidMount(() => {
        onRepositoryUpdated(setAirplanes);
    });

    return {
        add,
        deleteAiplanes,
        getCloseToAirport,
        getCloseToEachOther,
        getInRouteOfCollision,
        rotateCoordinates,
        scalonateCoordinates,
        translateCoordinates,
        clearLogs,
    } as const;
}
