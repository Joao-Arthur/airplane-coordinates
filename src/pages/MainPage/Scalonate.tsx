import { useState } from 'react';
import { Button } from '../../components/Button';
import { Input } from '../../components/Input';
import { useAirplaneStore } from '../../integrations/airplane/airplanesStore';
import { useAirplanes } from '../../integrations/airplane/useAirplanes';

export function Scalonate() {
    const { scalonateCoordinates } = useAirplanes();
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
