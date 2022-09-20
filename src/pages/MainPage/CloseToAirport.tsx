import { Button } from "../../components/Button";
import { Input } from "../../components/Input";

export function CloseToAirport() {
    return (
        <>
            <Input title='Distancia mínima' name='minDistance' />
            <Button title='Aviões próximos ao aeroporto' onClick={() => { }} />
        </>
    );
}