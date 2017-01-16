using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JobDescriptionCsharp.domain
{
    public class Task : Entity
    {
        public string description { get; set; }

        public Task(int id, string description)
        {
            this.id = id;
            this.description = description;
        }
    }
}
