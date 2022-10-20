import classNames from 'classnames';
import { nanoid } from 'nanoid';
import { Button } from '../components/Button';
import { useAirplaneStore } from '../integrations/airplane/airplanesStore';
import { useAirplanes } from '../integrations/airplane/useAirplanes';

export function Report() {
    const reports = useAirplaneStore(state => state.reports);
    const { clearLogs } = useAirplanes();

    function onClick() {
        clearLogs();
    }

    return (
        <div className='flex flex-col flex-1 h-1/2 p-1'>
            <div className='overflow-x-auto flex-1'>
                <table className='min-w-full text-sm divide-y-2 divide-gray-200'>
                    <tbody className='divide-y divide-gray-200'>
                        {reports.map(report => (
                            <tr key={nanoid()}>
                                <td className={
                                    classNames('px-4 py-2 whitespace-nowrap',
                                        report.type === 'success' ? 'bg-green-50' : '',
                                        report.type === 'error' ? 'bg-red-50' : '',
                                        report.type === 'warn' ? 'bg-yellow-50' : '',
                                    )
                                }>{report.content}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            {reports.length ? <Button onClick={onClick}>Limpar</Button> : null}
        </div>
    );
}
