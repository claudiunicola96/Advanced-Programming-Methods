using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JobDescriptionCsharp.exception
{
    class JobException : Exception
    {
        public JobException(string message) : base(message) { }
    }
}
