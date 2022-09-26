import { nanoid } from 'nanoid'
import { useState } from 'react';
import { useDidMount } from 'rooks';
import { messageType } from '../../models/message';

type props = {
    onLogUpdated: (callback: (logs: readonly messageType[]) => void) => void;
}

export function Report({ onLogUpdated }: props) {
    const [reports, setReports] = useState<readonly messageType[]>([]);

    useDidMount(() => { onLogUpdated(setReports); });

    return (
        <div className='overflow-x-auto'>
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
    )
}