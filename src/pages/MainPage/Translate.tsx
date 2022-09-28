import { useState } from 'react';
import { Button } from '../../components/Button';
import { Input } from '../../components/Input';
import { gatewayTranslateAirplaneCoordinatesParamsType } from '../../features/airplane/gateways';
import { useAirplaneStore } from './airplanesStore';

type props = {
    readonly translateCoordinates: (translateAirplaneCoordinatesParams: gatewayTranslateAirplaneCoordinatesParamsType) => void;
}

export function Translate({ translateCoordinates }: props) {
    const selectedIds = useAirplaneStore(state => state.selectedAirplanes);
    const [x, setX] = useState(0);
    const [y, setY] = useState(0);

    function onClick() {
        translateCoordinates({ selectedIds, x, y });
    }

    return (
        <>
            <Input title='X' name='x' value={x} onChange={setX} />
            <Input title='Y' name='y' value={y} onChange={setY} />
            <Button title='Transladar' onClick={onClick} />
        </>
    );
}