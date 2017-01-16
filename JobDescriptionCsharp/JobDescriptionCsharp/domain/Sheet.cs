using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JobDescriptionCsharp.domain
{
    class Sheet : Entity
    {
        private Job job { get; set; }
        private Task task { get; set; }

        public Sheet(int id, Job job, Task task)
        {
            this.id = id;
            this.job = job;
            this.task = task;
        }
    }
}
