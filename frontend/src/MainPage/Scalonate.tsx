import { useForm } from 'react-hook-form';
import { Button } from '../components/Button';
import { Form } from '../components/Form';
import { Group } from '../components/Group';
import { Input } from '../components/Input';
import { useAirplaneStore } from '../integrations/airplane/airplanesStore';
import { useAirplanes } from '../integrations/airplane/useAirplanes';

type fieldsType = {
    readonly x: string;
    readonly y: string;
}

export function Scalonate() {
    const { register, handleSubmit } = useForm<fieldsType>({
        defaultValues: {
            x: '1',
            y: '1',
        },
    });
    const { scalonateCoordinates } = useAirplanes();
    const selectedIds = useAirplaneStore(state => state.selectedAirplanes);

    function onHandleSubmit({ x, y }: fieldsType) {
        scalonateCoordinates({ selectedIds, x, y });
    }

    return (
        <Form name='Escalonar' onSubmit={handleSubmit(onHandleSubmit)}>
            <Group>
                <Input {...register('x', { required: true })} title='X' />
                <Input {...register('y', { required: true })} title='Y' />
            </Group>
            <Button>Executar</Button>
        </Form>
    );
}
