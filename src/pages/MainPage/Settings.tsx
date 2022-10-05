import { useForm } from 'react-hook-form';
import { Button } from '../../components/Button';
import { Form } from '../../components/Form';
import { Range } from '../../components/Range';
import { Select } from '../../components/Select';
import { useRadarStore } from '../../integrations/radar/radarStore';

type fieldsType = {
    readonly radarView: 'polar' | 'cartesian';
    readonly numberOfParts: number;
};

export function Settings() {
    const setNumberOfParts = useRadarStore(state => state.setNumberOfParts);
    const setRadarView = useRadarStore(state => state.setRadarView);
    const { register, handleSubmit } = useForm<fieldsType>({
        defaultValues: {
            radarView: 'cartesian',
            numberOfParts: 20,
        },
    });

    function onHandleSubmit({ numberOfParts, radarView }: fieldsType) {
        setNumberOfParts(numberOfParts);
        setRadarView(radarView);
    }

    return (
        <div>
            <Form name='Configurações' onSubmit={handleSubmit(onHandleSubmit)}>
                <Select
                    {...register('radarView')}
                    title='Estilo do radar'
                    options={[
                        { name: 'polar', label: 'Polar' },
                        { name: 'cartesian', label: 'Cartesiano' },
                    ]}
                />
                <Range
                    {...register('numberOfParts', { min: 0, max: 100 })}
                    title='Número de partes'
                />
                <Button title='Aplicar' />
            </Form>
        </div>
    );
}
