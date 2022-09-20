import { Button } from "../../components/Button";
import { Input } from "../../components/Input";

export function AddAirplane() {
    return (
        <>
            <Input title='X' name='x' />
            <Input title='Y' name='y' />
            <Input title='Raio' name='raio' />
            <Input title='Ângulo' name='angulo' />
            <Input title='Velocidade' name='velocidade' />
            <Input title='Direção' name='direcao' />
            <Button title='Adicionar' onClick={() => { }} />
        </>
    );
}