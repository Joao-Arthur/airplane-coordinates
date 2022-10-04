import { Button } from '../../components/Button';
import { Form } from '../../components/Form';
import { useAirplaneStore } from '../../integrations/airplane/airplanesStore';
import { useAirplanes } from '../../integrations/airplane/useAirplanes';

export function DeleteAirplane() {
    const { deleteAiplane } = useAirplanes();
    const { selectedAirplanes } = useAirplaneStore();

    function onClick() {
        for (const id of selectedAirplanes)
            deleteAiplane({ id });
    }

    return (
        <Form name='Deletar' onSubmit={e => { e.preventDefault(); onClick(); }}>
            <Button title='Deletar aviões selecionados' />
        </Form>
    );
}
