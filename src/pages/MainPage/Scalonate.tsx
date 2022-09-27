import { useState } from 'react';
import { Button } from '../../components/Button';
import { Input } from '../../components/Input';
import { gatewayScalonateAirplaneCoordinatesParamsType } from '../../features/airplane/gateways';

type props = {
    selectedIds: readonly string[];
    scalonateCoordinates: (scalonateAirplaneCoordinatesParams: gatewayScalonateAirplaneCoordinatesParamsType) => void;
}

export function Scalonate({ selectedIds, scalonateCoordinates }: props) {
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