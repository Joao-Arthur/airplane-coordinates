import { Button } from "../../components/Button";
import { Input } from "../../components/Input";

type props = {
    getCloseToAirport: (maxDistance: number) => void;
}

export function CloseToAirport({ getCloseToAirport }: props) {
    return (
        <>
            <Input title='Distancia mínima' name='minDistance' />
            <Button title='Aviões próximos ao aeroporto' onClick={() => { }} />
        </>
    );
}