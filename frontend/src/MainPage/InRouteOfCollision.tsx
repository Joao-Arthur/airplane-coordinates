import { useForm } from 'react-hook-form';
import { Button } from '../components/Button';
import { Form } from '../components/Form';
import { Input } from '../components/Input';
import { useAirplanes } from '../integrations/airplane/useAirplanes';

type fieldsType = {
    readonly maxTime: string;
}

export function InRouteOfCollision() {
    const { register, handleSubmit } = useForm<fieldsType>({
        defaultValues: {
            maxTime: '0',
        },
    });
    const { getInRouteOfCollision } = useAirplanes();

    function onHandleSubmit({ maxTime }: fieldsType) {
        getInRouteOfCollision({ maxTime });
    }

    return (
        <Form name='Aviões em rota de colisão' onSubmit={handleSubmit(onHandleSubmit)}>
            <Input {...register('maxTime', { min: '0', required: true })} title='Tempo mínimo' />
            <Button>Calcular</Button>
        </Form>
    );
}
