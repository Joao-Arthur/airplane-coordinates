import { useForm } from 'react-hook-form';
import { Button } from '../components/Button';
import { Form } from '../components/Form';
import { Group } from '../components/Group';
import { Input } from '../components/Input';
import { useAirplaneStore } from '../integrations/airplane/airplanesStore';
import { useAirplanes } from '../integrations/airplane/useAirplanes';

type fieldsType = {
    readonly x: number;
    readonly y: number;
}

export function Translate() {
    const { register, handleSubmit } = useForm<fieldsType>({
        defaultValues: {
            x: 0,
            y: 0,
        },
    });
    const { translateCoordinates } = useAirplanes();
    const selectedIds = useAirplaneStore(state => state.selectedAirplanes);

    function onHandleSubmit({ x, y }: fieldsType) {
        translateCoordinates({ selectedIds, x, y });
    }

    return (
        <Form name='Transladar' onSubmit={handleSubmit(onHandleSubmit)}>
            <Group>
                <Input {...register('x', { valueAsNumber: true, required: true })} title='X' />
                <Input {...register('y', { valueAsNumber: true, required: true })} title='Y' />
            </Group>
            <Button title='Executar' />
        </Form>
    );
}
