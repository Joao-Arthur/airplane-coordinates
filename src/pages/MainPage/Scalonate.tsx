import { useState } from 'react';
import { Button } from '../../components/Button';
import { Input } from '../../components/Input';
import { gatewayScalonateAirplaneCoordinatesParamsType } from '../../features/airplane/gateways';
import { useAirplaneStore } from './airplanesStore';

type props = {
    readonly scalonateCoordinates: (scalonateAirplaneCoordinatesParams: gatewayScalonateAirplaneCoordinatesParamsType) => void;
}

export function Scalonate({ scalonateCoordinates }: props) {
    const selectedIds = useAirplaneStore(state => state.selectedAirplanes);
    const [x, setX] = useState(0);
    const [y, setY] = useState(0);

    function onClick() {
        scalonateCoordinates({ selectedIds, x, y });
    }

    return (
        <>
            <Input title='X' name='x' value={x} onChange={setX} />
            <Input title='Y' name='y' value={y} onChange={setY} />
            <Button title='Escalonar' onClick={onClick} />
        </>
    );
}