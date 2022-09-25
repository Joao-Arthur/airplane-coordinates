import { useState } from "react";
import { Button } from "../../components/Button";
import { Input } from "../../components/Input";

type props = {
    getCloseToAirport: (maxDistance: number) => void;
}

export function CloseToAirport({ getCloseToAirport }: props) {
    const [maxDistance, setMaxDistance] = useState(0);

    function onClick() {

    }

    return (
        <>
            <Input title='Distancia mínima' name='maxDistance' value={maxDistance} onChange={setMaxDistance} />
            <Button title='Aviões próximos ao aeroporto' onClick={onClick} />
        </>
    );
}