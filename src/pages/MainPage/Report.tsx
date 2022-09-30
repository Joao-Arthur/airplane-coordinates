import { nanoid } from 'nanoid';
import { useAirplaneStore } from '../../integrations/airplane/airplanesStore';

export function Report() {
    const reports = useAirplaneStore(state => state.reports);

    return (
        <div className='overflow-x-auto h-1/2'>
            <table className='min-w-full text-sm divide-y-2 divide-gray-200'>
                <tbody className='divide-y divide-gray-200'>
                    {reports.map(report => (
                        <tr key={nanoid()}>
                            <td className='px-4 py-2 whitespace-nowrap'>{report.content}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div >
    );
}
